#!/bin/sh
alsaucm -n -b - <<EOM
open sdm845
set _verb HiFi
list _devices
EOM

# Required for the compressed device node
amixer cset name='SLIMBUS_0_RX Audio Mixer MultiMedia4' 1

# Required for PCM Playback device nodes
amixer cset name='SLIMBUS_0_RX Audio Mixer MultiMedia3' 1
amixer cset name='SLIMBUS_0_RX Audio Mixer MultiMedia2' 1
amixer cset name='SLIMBUS_0_RX Audio Mixer MultiMedia1' 1

systemctl restart pipewire
systemctl restart wireplumber
