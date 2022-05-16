function validateform(name, password, number, email) {
    if (name == null || name == "") {
        //alert("Name can't be blank");
        console.log("Name can't be blank");
        return false;
    } else if (password.length < 6) {
        //alert("Password must be at least 6 characters long.");
        console.log("Password must be at least 6 characters long.");
        return false;
    }

    if (isNaN(number)) {
        console.log("Enter a number");
        return false;
    }

    var atposition = email.indexOf("@");
    var dotposition = email.lastIndexOf(".");

    if (atposition < 1 || dotposition < atposition + 2 || dotposition + 2 >= email.length) {
        console.log("Enter valid email.");
        return false;
    }

}


validateform('name', 'abcdefg', 13,'hai@gmail.com');