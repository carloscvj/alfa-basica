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

if [ "${INSTALACION}" ]
then
	say "INSTALACION=${INSTALACION}"
else
	export INSTALACION=/usr/local;say "INSTALACION=${INSTALACION}"
fi

say "--------------------------------------------------------------------"

java -jar ${INSTALACION}/alfa-1.2/Alfa-gui-1.2-Z.jar ${*}

