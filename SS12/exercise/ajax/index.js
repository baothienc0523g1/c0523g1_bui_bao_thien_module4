//sau khi toàn bộ dữ liệu của trang được tải thì mới
// thực thi khối code bên trong -> tránh lỗi
$(document).ready(function () {
    display();
    displayCategory();


    //button more
    $("#btn-show-more").click(function () {
        display();
    })

    //onlick button save
    $("#btn-add").click(function () {
        let name = $("#name").val();
        let author = $("#author").val();
        let summary = $("#summary").val();
        let content = $("#content-blog").val();
        let dayCreate = $("#dayCreate").val();
        let category = $("#category").val();
        const blog = {
            name: name,
            author: author,
            summary: summary,
            content: content,
            dayCreate: dayCreate,
            category: {
                id: category
            }
        }
        //gọi hàm add()
        add(blog);
    })

    //button search
    $("#btn-search").click(function () {
       search();
    })

});

//khai báo biến page để cộng dồn trang
let page = 0;


//hiển thị
function display() {
    let content = "";
    $.ajax({
        contentType: "application/json",
        method: "GET",
        url: `http://localhost:8080/api/blogs?page=${page++}`,
        success: function (data) {
            console.log(data.content);
            for (let i = 0; i < data.content.length; i++) {
                content += `<tr>
                <td>${data.content[i].name}</td>
                <td>${data.content[i].author}</td>
                <td>${data.content[i].summary}</td>
                <td>${data.content[i].category.name}</td>
            </tr>`;
            }
            $("#content").append(content);
        },
    })
}

//display category for add new blog
function displayCategory() {
    let content = "";
    $.ajax({
        contentType: "application/json",
        method: "GET",
        url: `http://localhost:8080/api/categories`,
        success: function (data) {
            for (let i = 0; i < data.length; i++) {
                content += `<option value="${data[i].id}">${data[i].name}</option>`;
            }
            $("#category").html(content);
        },
    })
}

//function add
function add(blog) {
    $.ajax({
        contentType: "application/json",
        method: "POST",
        dataType: "json",
        data: JSON.stringify(blog),
        url: "http://localhost:8080/api/blogs/",
        complete: function () {
            display();
        }
    })
}

//function search
function search() {
    let content = "";
    let searchWord = $("#searchWord").val();
    $.ajax({
        contentType: "application/json",
        method: "GET",
        url: `http://localhost:8080/api/blogs?${searchWord}`,
        success: function (data) {
            for (let i = 0; i < data.length; i++) {
                content += `<tr>
                <td>${data[i].name}</td>
                <td>${data[i].author}</td>
                <td>${data[i].summary}</td>
                <td>${data[i].category.name}</td>
            </tr>`;
            }
            $("#content").html(content);
        },
    })
}
