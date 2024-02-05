## OpenEmbedded/Yocto BSP layer for EMAC Inc.

- This collection of layers provide support for standard EMAC Inc. Products for use with [OpenEmbedded/Yocto](https://docs.yoctoproject.org/).

#### Building

Install the Yocto Project host dependencies
- see the [Yocto Manual](https://www.yoctoproject.org/docs/current/ref-manual/ref-manual.html#required-packages-for-the-build-host) for installation instructions

Install kas v3.2: [kas Documentation](https://kas.readthedocs.io/en/latest/)
```shell
# Installing kas from source
cd /tmp; git clone https://github.com/siemens/kas.git;
cd kas; git checkout 3.2; sudo pip3 install .
```

#### Setting up the build env
1. Select a distro file from kas/distros (suggest: emac.yml)
2. Select a machine file from kas/machines (select based on your product)
3. Invoke the kas shell with the selected files separated by colons:
  - kas shell kas/distros/emac.yml:kas/machines/arm/ipac9x25.yml
  - This will bring you to the bitbake sourced shell env to run bitbake commands (See below)
4. Optionally invoke kas build with the selected files separated by colons:
  - kas build kas/distros/emac.yml:kas/machines/arm/ipac9x25.yml
  - This will start the task of "bitbake -c build target" where target is the default target for the distro
5. Optionally create a local-kas.yml file to pass to your kas builds to add additional customization
  - Example addition of local-kas.yml:
    - kas build kas/distros/emac.yml:kas/machines/arm/ipac9x25.yml:local-kas.yml
    - This file must be placed at the root of the git repository.

If you would like to place any downloads or shared cache in an alternative directory than the default, you can create a local-kas.yml file with contents:
```yml
# local-kas.yml
header:
  version: 12

local_conf_header:
  downloads: |
    DL_DIR ?= "/home/user/downloads"
    BB_GENERATE_MIRROR_TARBALLS ?= "1"
  sstate_cache: SSTATE_DIR ?= "/home/user/sstate-cache"
```


#### Using bitbake

There is a lot to know and understand about bitbake. For full documentation: https://docs.yoctoproject.org/bitbake/

```
Common targets are:
    core-image-base  (Base Poky Image)
    emac-image-full  (EMAC Standard Headless Image)
    emac-image-debug (EMAC Standard Headless Image with Debug Tools pre-installed)
```
To start the building of the choice image:
```shell
bitbake emac-image-debug
```
