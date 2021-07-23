#!/usr/bin/env bash

# set -x

board=""
## FIXME check to make sure that the board is in the array.known_boards="som ......"
## ${known_boards[@]} =~ '${1}'
if [ -z "$1" ];
then
    echo "Please pass a board in"
    exit 0;
else
    board=$1;
fi

## handle the file urls
script_path="${BASH_SOURCE[0]}"
while [ -h "$script_path" ];
do
    base_path="$( cd -P "$( dirname "$script_path" )" >/dev/null 2>&1 && pwd )"
    script_path="$(readlink "$script_path")"
    [[ $script_path != /* ]] && script_path="$base_path/$script_path" 
done
base_path="$( cd -P "$( dirname "$script_path" )" >/dev/null 2>&1 && pwd )"
repo_path="$base_path/recipes"


if [ -d "$repo_path" ];
then
    echo "The downloader is not meant to download over and over again. Please clean up your build and tra again later"
else
    mkdir -p "$repo_path";
    cd "$repo_path" || exit 1;
fi

## ALL BRANCHS THAT ARE NOT EMAC
branch="dunfell"

## urls
meta_emac="git@git.emacinc.com:OE/emac-oe.git"

## poky oe
meta_poky="git://git.yoctoproject.org/poky"
meta_openembedded="https://github.com/openembedded/meta-openembedded.git"

# qt
# meta_qt4="git://git.yoctoproject.org/meta-qt"
meta_qt5="https://github.com/meta-qt5/meta-qt5.git"

## vendor
meta_freescale="https://github.com/Freescale/meta-freescale.git"
meta_freescale_3rdparty="https://github.com/Freescale/meta-freescale-3rdparty.git"

# meta_toradex="git://git.toradex.com/toradex"
# meta_intel="git://git.yoctoproject.org/meta-intel"
# meta_tegra="git://github.com/madisongh/meta-tegra"

echo "Cloning repositories this may take up to ten minutes depending on you ISP speed"

## start calling git
for url in $meta_emac $meta_poky $meta_openembedded;
do
    if [ "$url" == "git@git.emacinc.com:OE/emac-oe.git" ];
    then
        git clone --quiet -b 5.4 $url;
    else
        git clone --quiet -b $branch $url;
    fi
done


if [ "$board" == "sommx6_350" ];
then
    for i in $meta_qt5 $meta_freescale $meta_freescale_3rdparty;
    do
        git clone --quiet -b $branch $i;
    done
fi

cd "$base_path" || exit 1;
cp "$repo_path"/emac-oe/oe-init-build-env "$base_path" || exit 1;

echo "Downloading repositories is now Done"
echo "You can now run:"
echo "	source oe-init-build-env"
