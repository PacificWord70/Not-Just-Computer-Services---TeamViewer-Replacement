#!/bin/bash

#############################################################################################
# This script is to automatically pull changes down from GitHub and update the live website #
#############################################################################################

##########
# Config #
##########

# Make temp folder to download into
mkdir /var/www/html/update

# Switch to newly made directory
cd /var/www/html/update

# Pull latest file from GitHub
wget -O git.zip https://github.com/techdev5521/Not-Just-Computer-Services---TeamViewer-Replacement/archive/master.zip

# Extract the file
unzip git.zip

# Remove existing files
cd ../
rm -r $(ls | grep -v update)
cd update/

# Move new files over
cp -rf Not-Just-Computer-Services---TeamViewer-Replacement-master/web-interface/* ../

# Move to web root
cd ../

# Cleanup
rm -r update/