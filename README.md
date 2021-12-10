## OpenEmbedded/Yocto BSP layer for EMAC Inc.

- This layer provides support for standard EMAC Inc. Products for use with OpenEmbedded/Yocto.

#### Dependencies:

Git repo tool is needed to maintian the outside dependencies. 
```
git@git.emacinc.com:OE/repo-tool.git
```

Basic tools for yocto
```
sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat libsdl1.2-dev xterm
```

#### Prepare the build environment

Clone repo tool

```
git clone git@git.emacinc.com:OE/repo-tool.git
```

cd directories into repo-tool and run the init script

```
cd repo-tool
./init-build.sh -g "default"
source setup_env.sh
bitbake emac-image
````

#### Using bitbake

See http://git.emacinc.com/OE/repo-tool/-/blob/master/emac_env.md for more details about the build options

```
Common targets are:
    emac-image (Headless)
    emac-qt4e-image (QT4 embedded)
    emac-qt4x-image (QT4 X11)
    emac-qt5-image (QT5 embedded)
```

#### The layers

****meta-emac****

All overwrites for the OE and yocto layer recipes

****meta-emac-bsp****
EMAC's BSP layer.  Note that this is going away soon

****meta-bringup****
Area for EMAC to bring up new boards for BSP intergration. This meta-layer is only used to bring a board up then all things should get merged into the meta-emac layer or there repected SOC vender layer. 

****meta-emac-freescale****

All recipes that get overwrote in the meta-freescale layer including the meta-freescale-3rdParty as well

****meta-emac-atmel****

All recipes that get overwrote in the meta-atmel layer

****meta-emac-qt****

All recipes for qt4 or qt5 layers

****meta-emac-tegra****

Recipes used when overwriting upstream meta-tegra
