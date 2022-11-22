## OpenEmbedded/Yocto BSP layer for EMAC Inc.

- This collection of layers provide support for standard EMAC Inc. Products for use with OpenEmbedded/Yocto.

#### Building

Install host dependencies
see [Yocto Manual](https://www.yoctoproject.org/docs/current/ref-manual/ref-manual.html#required-packages-for-the-build-host)

Install kas [kas Documentation](https://kas.readthedocs.io/en/latest/)
```shell
sudo apt -y install kas
```

#### Setting up the build env
1. Select a distro file from kas/distros (suggest: emac.yml)
2. Select a machine file from kas/machines (select based on your product)
3. Optionally select any files in kas/options (suggest: persistent_downloads_sstate.yml)
4. Invoke kas shell with the selected files separated by colons:
  - "kas shell kas/distros/emac.yml:kas/machines/ipac9x25.yml:kas/options/persistent_downloads_sstate.yml"
  - This will bring you to the bitbake sourced shell env to run bitbake commands (See below)
5. Optionally invoke kas build with the selected files separated by colons:
  - "kas build kas/distros/emac.yml:kas/machines/ipac9x25.yml:kas/options/persistent_downloads_sstate.yml"
  - This will start the task of "bitbake -c build target" where target is the default target for the distro
6. Optionally create a local-kas.yml file to pass to your kas builds to add additional customization

#### Using bitbake

```
Common targets are:
    core-image-base
    emac-image (Headless)
```
To start the building of the choice image:
```
bitbake emac-image
```
