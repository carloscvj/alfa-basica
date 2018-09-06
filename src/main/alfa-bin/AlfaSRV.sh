#!/bin/sh
#--------FUNCTIONS--------------------------------------------------
say() {
if [ "${args}" ]
    then
        nada=""
    else
        echo ${*}
fi
}
#------END FUNCTIONS-----------------------------------------------------

say "--------------------------------------------------------------------"
export COBDIR=/opt/lib/cobol
export LD_LIBRARY_PATH=/opt/lib/mflmf/coblib
export COBSW=-F

if [ "${INSTALACION}" ]
then
	say "INSTALACION=${INSTALACION}"
else
	export INSTALACION=/usr/local;say "INSTALACION=${INSTALACION}"
fi
say "--------------------------------------------------------------------"


######################## ACUERDATE DE QUITAR ESTO CUANDO TERMINES ###########################
pamatar=`ps xa|grep Alfa-gfs|awk '{print $1}'`
for i in ${pamatar}
do
    kill -9 $i 2>/dev/null
done

rm -rf /tmp/gfembed*
######################### HASTA AQUÍ ########################################################



java -jar ${INSTALACION}/alfa-1.0/Alfa-gfs-1.0-Z.jar ${*} &

