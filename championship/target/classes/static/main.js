function makeTable(container, data) {
    var table = $("<table/>").addClass('playerTable');

    var headerRow = $("<tr/>");
    headerRow.append($("<th/>").text("ID"));
    headerRow.append($("<th/>").text("Name"));
    headerRow.append($("<th/>").text("Age"));
    headerRow.append($("<th/>").text("Position"));
    headerRow.append($("<th/>").text("Number"));
    table.append(headerRow);
    $.each(data, function (rowIndex, r) {

        var row = $("<tr/>");
        $.each(r, function (colIndex, c) {
            row.append($("<td/>").text(c));
        });
        table.append(row);
    });
    return container.append(table);
}

$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/player/all",
        type: "GET",
        dataType: "json",
        success: function (data) {
            var tableContainer = $("#tableContainer");
            makeTable(tableContainer, data);
        },
        error: function (data) {
            alert('Error: ' + data);
        }
    });
});