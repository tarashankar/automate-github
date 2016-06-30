#!/bin/bash
# My first script

git init
git clone https://github.com/tarashankar/created-by-ui.git
cd created-by-ui
touch readme2.txt
git add readme2.txt
git commit -m "readme2.txt added by script"
git push https://username:password@github.com/yusername/created-by-ui.git

# git pull https://username:password@mygithost.com/my/repository
