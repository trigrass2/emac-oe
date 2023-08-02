#!/bin/bash
############################################################################
##
## Copyright (C) 2021 Emacs inc.
## Contact: https://www.emacinc.com
##
## Copyright (C) 2021 The Qt Company Ltd.
## Contact: https://www.qt.io/licensing/
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
##
###########################################################################

set -e

ABI="arm-linux-emac-elf-32bit"
CONFIG=""

printUsage ()
{
    echo "Usage: $0 --config <environment-setup-file> [--remove] [--qtcreator <path>] [--name <basename>]"
}

## the base of the qtcreator. note that this can be overwrote with passing in the --qtcreator option
QTCREATOR="/usr/bin/qtcreator"
SDKTOOL="/usr/lib/x86_64-linux-gnu/qtcreator/libexec/sdktool"

while test -n "$1"; do
  case "$1" in
    "--remove")
      REMOVEONLY=1
      ;;
    "--qtcreator")
      shift
      QTCREATOR=$1
      ;;
    "--config")
      shift
      CONFIG=$1
      ;;
    "--name")
      shift
      NAME=$1
      ;;
    *)
      printUsage
      exit 0
      ;;
  esac
  shift
done

if [ ! -f "$CONFIG" ]; then
   printUsage
   exit 1
fi



if [ ! -x ${SDKTOOL} ]; then
    echo "Cannot find 'sdktool' from QtCreator"
    printUsage
    exit 1
fi

source $CONFIG

MKSPEC="devices/linux-oe-generic-g++"
MKSPECPATH=$(find ${OECORE_TARGET_SYSROOT} -name $(basename ${MKSPEC}) 2>/dev/null || true)
if [ ! -d "${MKSPECPATH}" ]; then
    echo "Error: could not find mkspec ${MKSPEC} from the toolchain"
    exit 1
fi

MACHINE=$(grep '^MACHINE' ${MKSPECPATH}/../../qdevice.pri | cut -d'=' -f2 | tr -d ' ')
RELEASE=$(qmake -query QT_VERSION)

NAME=${NAME:-"EMAC Qt ${RELEASE} ${MACHINE}"}
BASEID="byos.${RELEASE}.${MACHINE}"

${SDKTOOL} rmKit --id ${BASEID}.kit 2>/dev/null || true
${SDKTOOL} rmQt --id ${BASEID}.qt || true
${SDKTOOL} rmTC --id ProjectExplorer.ToolChain.Gcc:${BASEID}.gcc || true
${SDKTOOL} rmTC --id ProjectExplorer.ToolChain.Gcc:${BASEID}.g++ || true
${SDKTOOL} rmDebugger --id ${BASEID}.gdb 2>/dev/null || true
${SDKTOOL} rmCMake --id ${BASEID}.cmake 2>/dev/null || true

if [ -n "${REMOVEONLY}" ]; then
    echo "Kit removed: ${NAME}"
    exit 0
fi

${SDKTOOL} addAbiFlavor \
    --flavor emac \
    --oses linux || true

${SDKTOOL} addTC \
    --id "ProjectExplorer.ToolChain.Gcc:${BASEID}.gcc" \
    --name "EMAC OE gcc (${NAME})" \
    --path "$(type -p ${CC})" \
    --abi "${ABI}" \
    --language C

${SDKTOOL} addTC \
    --id "ProjectExplorer.ToolChain.Gcc:${BASEID}.g++" \
    --name "EMAC OE g++ (${NAME})" \
    --path "$(type -p ${CXX})" \
    --abi "${ABI}" \
    --language Cxx

${SDKTOOL} addDebugger \
    --id "${BASEID}.gdb" \
    --name "EMAC OE GDB (${NAME})" \
    --engine 1 \
    --binary "$(type -p ${GDB})" \
    --abis "${ABI}"

${SDKTOOL} addQt \
    --id "${BASEID}.qt" \
    --name "EMAC OE ${NAME}" \
    --type "Qdb.EmbeddedLinuxQt" \
    --qmake "$(type -p qmake)"

${SDKTOOL} addCMake \
    --id "${BASEID}.cmake" \
    --name "EMAC OE CMake ${NAME}" \
    --path "$(type -p cmake)"

${SDKTOOL} addKit \
    --id "${BASEID}.kit" \
    --name "EMAC OE ${NAME}" \
    --qt "${BASEID}.qt" \
    --debuggerid "${BASEID}.gdb" \
    --sysroot "${SDKTARGETSYSROOT}" \
    --devicetype "QdbLinuxOsType" \
    --Ctoolchain "ProjectExplorer.ToolChain.Gcc:${BASEID}.gcc" \
    --Cxxtoolchain "ProjectExplorer.ToolChain.Gcc:${BASEID}.g++" \
    --icon ":/boot2qt/images/B2Qt_QtC_icon.png" \
    --mkspec "${MKSPEC}" \
    --cmake "${BASEID}.cmake" \
    --cmake-config "CMAKE_TOOLCHAIN_FILE:FILEPATH=${OECORE_NATIVE_SYSROOT}/usr/share/cmake/OEToolchainConfig.cmake" \
    --cmake-config "CMAKE_MAKE_PROGRAM:FILEPATH=$(type -p make)" \
    --cmake-config "CMAKE_CXX_COMPILER:FILEPATH=$(type -p ${CXX})" \
    --cmake-config "CMAKE_C_COMPILER:FILEPATH=$(type -p ${CC})"

echo "Configured EMAC Qt Creator with new kit: ${NAME}"
