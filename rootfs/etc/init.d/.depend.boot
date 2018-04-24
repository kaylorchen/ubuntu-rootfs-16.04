TARGETS = mountkernfs.sh hostname.sh mountdevsubfs.sh procps hwclock.sh checkroot.sh urandom mountnfs-bootclean.sh mountnfs.sh bootmisc.sh checkfs.sh mountall.sh checkroot-bootclean.sh mountall-bootclean.sh
INTERACTIVE = checkroot.sh checkfs.sh
mountdevsubfs.sh: mountkernfs.sh
procps: mountkernfs.sh
hwclock.sh: mountdevsubfs.sh
checkroot.sh: hwclock.sh mountdevsubfs.sh hostname.sh
urandom: hwclock.sh
mountnfs-bootclean.sh: mountnfs.sh
bootmisc.sh: mountnfs-bootclean.sh checkroot-bootclean.sh mountall-bootclean.sh
checkfs.sh: checkroot.sh
mountall.sh: checkfs.sh checkroot-bootclean.sh
checkroot-bootclean.sh: checkroot.sh
mountall-bootclean.sh: mountall.sh
