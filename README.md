## OpenEmbedded/Yocto BSP layer for EMAC Inc.

- This layer provides support for standard EMAC Inc. Products for use with OpenEmbedded/Yocto.

#### Dependencies:

Required tools for Ubuntu/Debian distributions ( [YoctoProject Required Packages](https://www.yoctoproject.org/docs/current/ref-manual/ref-manual.html#ubuntu-packages) )
```
sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat cpio python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev pylint3 xterm
```

#### Prepare the build environment

Clone this repository for distro duncan:
```
git clone -b v5.8.0-duncan-rc2 http://git.emacinc.com/OE/emac-oe.git .
```

Initialize the Repo-Tool submodule

```
git submodule sync --recursive
git submodule update --init --recursive
```

Change directories into repo-tool and run the init script

```
cd repo-tool
./init-build.sh -g "default"
source setup_env.sh
````

#### Using bitbake

See [emac_env.md](http://git.emacinc.com/OE/repo-tool/-/blob/master/emac_env.md) for more details about the build options

```
Common targets are:
    emac-image (Headless)
    emac-qt4e-image (QT4 embedded)
    emac-qt4x-image (QT4 X11)
    emac-qt5-image (QT5 embedded)
```
To start the building of the choice image:
```
bitbake emac-image
```
