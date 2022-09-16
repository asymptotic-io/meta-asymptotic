DESCRIPTION = "Vinod Koul's fork of fcplay"

BB_STRICT_CHECKSUM = "0"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=3605e19a4b9ddd7f5f54f010279f1760"

DEPENDS = "alsa-lib ffmpeg tinycompress"

SRCREV = "716f44125301829bc02276f1c58a918bbea7828d"
SRC_URI = "git://github.com/vinodkoul/fcplay.git;protocol=https;branch=flac"
SRC_URI[sha256sum] = "f791935cf45c06a413c61cb85431b4e69c5fed769edd5469e1fce1c98d6f1149"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
