# automate-github

This project is about automating github through selenium and testing is performed through TestNG.

It perform the following actions:-

1. Auto login to your github account, and validate the login actions and page.
2. Create a new repository, and validate if repository is created.
3. Adding a new file to the repository. This is done through shell scripting in linux. All the commands of shell are in file shell.sh in package shell folder. It uses the command of push to update the newly created file after cloning the repository.
4. Checking commit text and validate. It checks from web as well as the repository to check whether commit texts are same.
5. Checking and validating commit ID. This also checks from both places in the .git folder and also from web.
6. Inserting some new text into newly created file (ui automation) and validate.
7. Delete the created repository and validate.

The main class is TestClass

Edit the .sh file by your username and password.
Also in the every class just replace username and password with your own

TestNG.jar is required to be added in your project.

If you also want to delete the clone reository:-
just add these lines in the sh file
rm -rf filepath

All class names and functions are self explanatory, even if you want any help just push
