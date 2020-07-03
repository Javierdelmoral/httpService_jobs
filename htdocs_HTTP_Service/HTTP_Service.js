function crear() {
    document.getElementById("fullInfo").innerHTML = "";//para setear a empty la info en html
    document.getElementById("data").innerHTML = "";//para setear a empty la info en html
    document.getElementById("sameRoles").innerHTML = "";//para setear a empty la info en html

    var createEmployeeName = document.getElementById("employee_name_create").value;
    var createEmployeeRole = document.getElementById("employee_role_create").value;
    var newEmployee = {

        name: createEmployeeName,
        role: createEmployeeRole.toUpperCase()

    };

    var createdEmployee = JSON.stringify(newEmployee);

    if (createEmployeeName != "") {

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/employees/",
            contentType: "application/json",
            dataType: "json",
            data: createdEmployee,
            success: function (data) {

                //createEmployee;
                console.log("new employee created: " + createdEmployee);
                alert("Employee with name: " + createEmployeeName + " and role " + createEmployeeRole + " has been created!");


            },
            error: function () {

                alert("Something went wrong!")
            }
        });

    } else {
        alert("You should enter a Name!");
    }
}


function update() {
    document.getElementById("fullInfo").innerHTML = "";
    document.getElementById("data").innerHTML = "";
    document.getElementById("sameRoles").innerHTML = "";

    var employeeID = +document.getElementById("employee_id_modify").value;

    if (employeeID != "") {

        var modifiedEmployee = new Object();
        modifiedEmployee.name = prompt("Please enter the modified name of this employee");
        modifiedEmployee.role = prompt("Please enter the modified role of this employee. Thief, Burglar or Mage.").toUpperCase();

        var jsonEmployee = JSON.stringify(modifiedEmployee);

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/employees/id/" + employeeID,
            contentType: "application/json",
            dataType: "json",
            data: jsonEmployee,
            success: function (data) {

                alert("Employee with name: " + modifiedEmployee.name + " and role " + modifiedEmployee.role + " has been modified!");
                console.log(jsonEmployee);

            },
            error: function (data) {

                alert("Something went wrong!");
            }
        });

    } else {
        alert("You should enter an ID!");
    }
}


function delete_() {
    document.getElementById("fullInfo").innerHTML = "";
    document.getElementById("data").innerHTML = "";
    document.getElementById("sameRoles").innerHTML = "";

    var employeeID = +document.getElementById("employee_id_modify").value;

    if (employeeID != "") {

        var idJSON = JSON.stringify(employeeID);

        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/employees/id/" + employeeID,
            contentType: "application/json",
            data: idJSON,
            success: function () {

                alert("Employee with id: " + employeeID + " has been erased!");

            },
            error: function (data) {

                alert("Something went wrong");
            }
        });

    } else {
        alert("You should enter an ID!");
    }
}


function readPerId() {

    document.getElementById("erase_repeated_results").innerHTML = ""; //to erase info I don't want to store
    document.getElementById("fullInfo").innerHTML = "";
    document.getElementById("data").innerHTML = "";
    document.getElementById("sameRoles").innerHTML = "";
    document.getElementById("showList").innerHTML = "";

    var employeeId = document.getElementById("employee_id").value;

    if (employeeId !== "") {

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/employees/id/" + employeeId,
            success: function (data) {

                //print the employees of bbdd

                document.getElementById("fullInfo").innerHTML += "Complete info: " + "<br />" + "<br />" +
                    "The ID of this employee is: " + data.id + "<br />" +
                    "The name of this employee is: " + data.name + "<br />" +
                    "The role of this employee is: " + data.role + "<br />" + "<br />";

                document.getElementById("data").innerHTML = JSON.stringify(data);
                console.log(data);
            },
            error: function () {

                alert("Something went wrong! Maybe you are entering parameters not related to our Database!");
            }
        });
    } else {
        alert("You should enter an ID!");

    }
}


function readPerName() {

    document.getElementById("erase_repeated_results").innerHTML = ""; //to erase info I don't want to store
    document.getElementById("fullInfo").innerHTML = "";
    document.getElementById("data").innerHTML = "";
    document.getElementById("sameRoles").innerHTML = "";
    document.getElementById("showList").innerHTML = "";

    var employeeName = document.getElementById("employee_name").value;

    //if input isn't empty...
    if (employeeName !== "") {

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/employees/name/" + employeeName,
            success: function (data) {

                //print the employees of bbdd
                for (var j = 0; j < data.length; j++) {

                    document.getElementById("fullInfo").innerHTML += "Complete info of employee " + (j + 1) + ": " + "<br />" + "<br />" +
                        "The ID of this employee is: " + data[j].id + "<br />" +
                        "The name of this employee is: " + data[j].name + "<br />" +
                        "The role of this employee is: " + data[j].role + "<br />" + "<br />";

                    document.getElementById("data").innerHTML = JSON.stringify(data);
                    console.log(data[j]);
                };

                if (data.length > 1) {

                    document.getElementById("erase_repeated_results").innerHTML = "Employees with the same name in our Database: " + data.length;

                }
            },
            error: function () {

                alert("Something went wrong! Maybe you are entering parameters not related to our Database!");
            }
        });

    } else {
        alert("You should enter a Name!");

    }
}

function showNames() {

    document.getElementById("erase_repeated_results").innerHTML = ""; //to erase info I don't want to store
    document.getElementById("fullInfo").innerHTML = "";
    document.getElementById("data").innerHTML = "";
    document.getElementById("sameRoles").innerHTML = "";
    document.getElementById("showList").innerHTML = "";

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/employees/",
        success: function (data) {

            //print the names of employees of bbdd
            for (var j = 0; j < data.length; j++) {

                document.getElementById("showList").innerHTML += data[j].name + ", ";

                console.log(data[j].name);
            };
        }
    });


}


function readPerRole() {

    document.getElementById("erase_repeated_results").innerHTML = ""; //to erase info I don't want to store
    document.getElementById("fullInfo").innerHTML = "";
    document.getElementById("data").innerHTML = "";
    document.getElementById("sameRoles").innerHTML = "";
    document.getElementById("showList").innerHTML = "";

    var employeeRole = document.getElementById("employee_role").value.toUpperCase();

    if (employeeRole !== "") {

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/employees/role/" + employeeRole,
            success: function (data) {

                //print the employees of bbdd
                for (var j = 0; j < data.length; j++) {

                    document.getElementById("fullInfo").innerHTML += "Complete info of employee " + (j + 1) + ": " + "<br />" + "<br />" +
                        "The ID of this employee is: " + data[j].id + "<br />" +
                        "The name of this employee is: " + data[j].name + "<br />" +
                        "The role of this employee is: " + data[j].role + "<br />" + "<br />";

                    console.log(data[j]);
                };

                if (data.length > 1) {

                    document.getElementById("sameRoles").innerHTML = "Employees with the same role in our Database: " + data.length + "<br />" +
                        "Complete list with salaries: ";

                    document.getElementById("data").innerHTML += JSON.stringify(data);

                } else {
                    document.getElementById("data").innerHTML = JSON.stringify(data);

                }
            },
            error: function () {

                alert("Something went wrong! Maybe you are entering parameters not related to our Database!");
            }
        });
    }
}








/* LOOPS TO DO WHAT PUT ALREADY DOES.........JEJEJEJE
for (var i = 0; i < data.length; i++) {

    if (employeeID == data[i].id) {

        data[i].name = modifiedEmployee.name;
        data[i].rol = modifiedEmployee.role;

        console.log(data);

    } else {

        alert("None of this inputs exists in our Database!");

        console.log(data);

    }
}
*/