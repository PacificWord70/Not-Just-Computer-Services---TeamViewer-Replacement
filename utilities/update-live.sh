#!/bin/bash

#############################################################################################
# This script is to automatically pull changes down from GitHub and update the live website #
#############################################################################################

##########
# Config #
##########

DOWNLOAD_PATH='/tmp/njcs-tvr'
DOWNLOAD_FILE='https://github.com/techdev5521/Not-Just-Computer-Services---TeamViewer-Replacement/archive/master.zip'
DOWNLOAD_FILE_NAME='git.zip'
WEB_ROOT='/var/www/html/'



# Pull latest file from GitHub
wget -O ${DOWNLOAD_PATH}/${DOWNLOAD_FILE_NAME} ${DOWNLOAD_FILE}

# Extract the file
unzip ${DOWNLOAD_PATH}/${DOWNLOAD_FILE_NAME}

# Delete the archive
rm ${DOWNLOAD_PATH}/${DOWNLOAD_FILE_NAME}

# Move new files over
cp ${DOWNLOAD_PATH}/Not-Just-Computer-Services---TeamViewer-Replacement-master/web-interface/* ${WEB_ROOT}

# Delete old files
rm -r ${DOWNLOAD_PATH}/*