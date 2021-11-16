## OpenEmbedded/Yocto BSP layer for EMAC Inc.

- This layer provides support for standard EMAC Inc. Products for use with OpenEmbedded/Yocto.

### Layer Dependencies:

>URI: git://git.yoctoproject.org/poky
layers: meta
branch: master

>URI: git://git.openembedded.org/meta-openembedded
layers: meta-oe meta-networking meta-python meta-efl meta-multimedia meta-gnome
branch: master

#### Optionally
>URI: git://git.yoctoproject.org/meta-qt4
layers: meta
branch: master

>https://github.com/meta-qt5/meta-qt5.git
layers: meta
branch: master

### EMAC OE Workflow

To build an EMAC OE filesystem, there are three basic steps:

###### Prepare the build environment
Create a subdirectory called recipes and change into it
```sh
mkdir recipes
cd recipes
```
Download the openembedded-core,meta-openembedded and EMAC meta data:
```sh
cd recipes
git clone -b dunfell git://git.yoctoproject.org/poky
git clone -b dunfell git://git.openembedded.org/meta-openembedded
git clone -b dunfell http://git.emacinc.com/OE/emac-oe.git
```
Checkout the appropriate branches of the repositories.

*EMAC OE 5.4 is based on OpenEmbedded/Yocto Dunfell branch*
```sh
cd emac-oe
git checkout 5.4
cd -
```
Apply any poky or mete-openembedded patches. Patches to the upstream repositories are located in the emac-oe/patches directory and include instructions on applying.
None needed for EMAC OE 5.4

Copy the oe-init-build-env script from the emac directory to one level above recipes/:
```sh
cd recipes
cp emac-oe/oe-init-build-env ../
cd ../
```
Initialize the build environment using the oe-init-build-env script, then select a machine to build for. The example below assumes that a standard EMAC image is to be built:
```sh
$ source ./oe-init-build-env
```
Select the target machine category, then select the target machine. Also select the target machine carrier board if required.

```sh
cd build
bitbake emac-image
```
To build a standalone toolchain, select 'sdk' as the target machine category and select either x86 or arm
```sh
cd build
bitbake meta-toolchain-emac
```

If any Qt recipes or meta-toolchain-emac are to be built, download and checkout the Qt meta data:
```sh
cd recipes
git clone git://git.yoctoproject.org/meta-qt4
git clone https://github.com/meta-qt5/meta-qt5.git
cd meta-qt4 && git checkout dunfell && cd ..
cd meta-qt5 && git checkout dunfell && cd ..
```
Add the Qt layers paths to build_5.4/conf/bblayers.conf. ${recipes_dir} is the full path to where the recipes are downloaded.
```
${recipes_dir}/meta-qt4
${recipes_dir}/meta-qt5
${recipes_dir}/emac-oe/meta-emac-qt
```

### Overview of EMAC OE Layers

**meta-emac**

> This is the location for EMAC's customization of Yocto/OpenEmbedded.
>It contains the EMAC distro layer that extends the core recipes.

**meta-emac-bsp**

> This layer will define EMAC's "board support package" layers which will provide board specific functionality.

**meta-emac-qt**

> Qt4 and Qt5 related recipes.

For more information, visit our wiki at http://wiki.emacinc.com/
