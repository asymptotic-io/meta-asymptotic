DESCRIPTION = "A library to handle compressed formats like MP3 etc."

BB_STRICT_CHECKSUM = "0"
LICENSE = "LGPL-2.1-only | BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=cf9105c1a2d4405cbe04bbe3367373a0"

DEPENDS = "alsa-lib ffmpeg"

SRCREV = "fef7b85f0c92cdd88af8a33a34ea0f29013dde1b"
SRC_URI = "git://github.com/asymptotic-io/tinycompress.git;protocol=https;branch=get_caps"

S = "${WORKDIR}/git"

# The fcplay in tinycompress does not work for WMA
# EXTRA_OECONF:append = " --enable-fcplay"

inherit autotools pkgconfig
