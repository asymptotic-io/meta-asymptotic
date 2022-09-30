SUMMARY = "Boot up script to set up UCM for compressed offload"
DESCRIPTION = "Script to setup UCM before Pipewire and Wireplumber start"
LICENSE = "CLOSED"

BB_STRICT_CHECKSUM = "0"

SRC_URI = " \
    file://compressed-setup.sh \
    file://reload-dsp.sh \
"

S = "${WORKDIR}"

do_install:append() {
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/compressed-setup.sh ${D}${sbindir}
    install -m 0755 ${WORKDIR}/reload-dsp.sh ${D}${sbindir}
}
