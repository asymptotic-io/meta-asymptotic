DESCRIPTION = "A library to handle compressed formats like MP3 etc."

BB_STRICT_CHECKSUM = "0"
LICENSE = "LGPL-2.1-only | BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=cf9105c1a2d4405cbe04bbe3367373a0"

DEPENDS = "alsa-lib ffmpeg"

SRCREV = "7dc18a725646f2662042aa17a5a181739f0c8021"
SRC_URI = "git://git.alsa-project.org/tinycompress.git;protocol=git;branch=master"

S = "${WORKDIR}/git"

EXTRA_OECONF:append = " --enable-fcplay"

inherit autotools pkgconfig
