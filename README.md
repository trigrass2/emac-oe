## OpenEmbedded/Yocto BSP layer for EMAC Inc.

- This layer provides support for standard EMAC Inc. Products for use with OpenEmbedded/Yocto.

---
## Setting up Host Machine

Install Yocto Host Dependencies:
See [Yocto Manual](https://docs.yoctoproject.org/current/ref-manual/system-requirements.html#required-packages-for-the-build-host)

```
$ sudo apt install gawk wget git diffstat unzip texinfo gcc build-essential chrpath socat cpio python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev pylint xterm python3-subunit mesa-common-dev zstd liblz4-tool
```

Install kas (=>v3.1): [kas documentation](https://kas.readthedocs.io/en/latest/userguide.html)
- We use kas to automate the population of the build environment from a set of yml files. 
- For those familiar with bitbake, kas will checkout repositories at specified revisions, generate the bblayers.conf and local.conf files, and run oe-init-build-env upon startup before building the specifed target.
- kas has a shell interface for experienced bitbake developers and a containerized (kas-container) for those needing to containerize the build.
```
cd /tmp; git clone https://github.com/siemens/kas.git;
cd kas; git checkout 3.1; sudo pip3 install .
```

If you would like to place any downloads or shared cache in an alternative directory than the default, you can create a local-kas.yml file with contents:
```
header:
  version: 12

local_conf_header:
  downloads: |
    DL_DIR ?= "/home/user/downloads"
    BB_GENERATE_MIRROR_TARBALLS ?= "1"
  sstate_cache: SSTATE_DIR ?= "/home/user/sstate-cache"
```
You could also add additional development additions in your local-kas.yml like debug-tweak or pointing the image's packagemanagement at your http server:
```
# add these under the local_conf_header
  point_to_me_for_packages: |
    PRSERV_HOST = "localhost:0"
    IMAGE_FEATURES:append = " debug-tweaks package-management"
    PACKAGE_CLASSES = "package_ipk"
    PACKAGE_FEED_URIS = "http://192.168.X.X:80" # enter your own PC's IP here if using a local server
    PACKAGE_FEED_BASE_PATHS = "ipk"
    PACKAGE_FEED_ARCHS = "${ALL_MULTILIB_PACKAGE_ARCHS}"
```
---
## Build
This may take several hours the first build. Afterward, it will reuse what it can for subsequent builds from the sstate-cache.

```
kas build kas/machines/ipac9x25.yml
```
or if using local-kas.yml
```
kas build kas/machines/ipac9x25.yml:local-kas.yml
```
- Machines
  - hmi-043t
  - intel-x86
  - ipac9x25
  - ppc-150t
  - som3354
  - som3517
  - som9g25
  - som9g45
  - som9x25
  - soma5d36
  - soma5d36mp
  - somimx6
  - somimx6q-ha
  - somimx6ul
  - vortex-sbc
  - vox-150

---
## Deployable Files

Once the build in complete, the deployment files will be located in ```build/tmp-${TCLIB}/deploy/```
- **deb**: Debian packages generated (dpkg)
- **ipk**: OpenEmbedded packages generated (opkg - default package type used)
- **rpm**: RedHat packages generated (dnf)
- **images**: where the root filesystems, kernel binaries, bootloader binaries, manifest files (what is installed on the rootfs)
- **licenses**: license information for each package installed
---
## Using the Package Management
You will need to create the package index for the packages you generated
```
kas shell kas/machines/ipac9x25.yml -c "bitbake package-index"
```
You will need to setup a webserver or ftp that can be accessed from the board and set the ```PACKAGE_FEED_URIS``` variable to match that location, move or copy the deployment folder contents to the net accessible location.

Alternatively, you can use python's builtin simple http server to "host" the packages while in development.
```
python3 -m http.server --directory build/tmp-${TCLIB}/deploy/ 80
```
---
## Customization

You can add your own layer by starting the kas shell for you machine with no command and editing the build/conf/bblayers file to include your layers path in the BBLAYERS variable or by adding the repository to your own machine file based on an emac machine like so (this will checkout under build/layers):
```
header:
  version: 12
  includes:
    - kas/machines/ipac9x25.yml

# my custom-machine based on the ipac9x25 from my-custom-layer
machine: custom-machine

repos:
  meta-custom:
    # if using https on a private repo instead of ssh, it will as for your user and pass in the checkout
    url: ssh://git@gitlab.com/my-custom-layer.git
    path: build/layers/meta-custom
    refspec: branch/tag/sha # leave blank for default (dunfell)

```
There is a bitbake/yocto bug that exists that causes build errors if there is a relative path in the BBLAYERS variable, this is why we stick the checkouts under the build dir instead of at the repo root.
