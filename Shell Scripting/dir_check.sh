#!/bin/sh

ROOT="/home/"
USER=$(whoami)
DES="/Desktop/"
DIR="$ROOT$USER$DES"

parent="APP/"
admin="admin/"
images="images/"
user="user/"
index="index.html"

echo $DIR

sudo mkdir "$DIR$parent" "$DIR$admin" "$DIR$images" "$DIR$user"
sudo touch "$DIR$index"
