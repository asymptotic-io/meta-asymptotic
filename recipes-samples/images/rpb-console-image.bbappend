# We have our recipe with minor modifications
BBMASK += "meta-openembedded/meta-oe/recipes-multimedia/pipewire/"
BBMASK += "meta-openembedded/meta-oe/recipes-multimedia/wireplumber/"

IMAGE_INSTALL += " \
	tinycompress \
	libsndfile1 \
	pipewire \
	wireplumber \
	pipewire-tools \
	pipewire-spa-tools \
	gstreamer1.0-plugins-base \
	gstreamer1.0-plugins-good \
	gstreamer1.0-plugins-bad \
	gstreamer1.0-plugins-ugly \
	gstreamer1.0-libav \
	ffmpeg \
	firmware-qcom-dragonboard845c \
	udev-extra-rules \
	pd-mapper \
	rmtfs \
	tqftpserv \
	fastrpc \
	compressed-setup \
	fcplay \
	"
