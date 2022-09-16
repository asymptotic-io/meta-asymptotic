meta-asymptotic
================================

Introduction
-------------------------

This OpenEmbedded/Yocto Project layer is for testing Pipewire with ALSA
compressed offload support on Dragonboard 845c/RB3 platform.

The meta-asymptotic layer primarily depends on:

	URI: https://github.com/96boards/meta-rpb
	layers: meta-rpb
	branch: kirkstone

	URI: http://git.yoctoproject.org/git/meta-qcom
	layers: meta-qcom
	branch: kirkstone

Please follow the recommended setup procedures for Yocto/OpenEmbedded.

Notes
-------------------------

Below is the complete list of layers expected in bblayers.conf.

```
meta
meta-poky
meta-yocto-bsp
meta-qcom
meta-openembedded/meta-oe
meta-openembedded/meta-python
meta-openembedded/meta-filesystems
meta-openembedded/meta-networking
meta-openembedded/meta-multimedia
meta-virtualization
meta-selinux
meta-96boards
meta-rpb
meta-asymptotic
```

Before building the image, add the following to local.conf.

```
DISTRO = "asymptotic"
```

The image to build is `rpb-console-image`. We `.bbappend` this image to add
additional packages.

Testing compressed offload on RB3/Dragonboard 845c
-------------------------

Disable `pipewire` and `wireplumber` from starting by default.

```bash
systemctl disable pipewire
systemctl disable wireplumber
```

Execute UCM configuration.

```bash
# alsaucm -n -b - <<EOM
open sdm845
set _verb HiFi
list _devices
EOM
```

For compressed node to use `cplay`

```bash
amixer cset name='SLIMBUS_0_RX Audio Mixer MultiMedia4' 1
```

For PCM Playback to use `aplay`

```bash
amixer cset name='SLIMBUS_0_RX Audio Mixer MultiMedia2' 1
```

Test basic playback is working on RB3.

```bash
aplay -D hw:0,1 Front_Center.wav
cplay -c 0 -d 3 jambi.mp3
```

Now start `pipewire` and `wireplumber`.

```bash
systemctl start pipewire
systemctl start wireplumber
```

To test compressed offload with `pipewire`, on one terminal execute

```bash
pw-cat -o -p jambi.mp3 --target 0
```

and on another

```bash
pw-link pw-cat Compressed-Sink
```

Dot graph
-------------------------

![](pw-smart.svg)

Maintainers
-------------------------

* Sanchayan Maity <sanchayan@asymptotic.io>
