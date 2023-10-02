function addNewSmartPhone() {
    // lấy dữ liệu từ form ở trang HTML
    let producer = $('#producer').val();
    let model = $('#model').val();
    let price = $('#price').val();
    let newSmartPhone = {
        producer: producer,
        model: model,
        price: price
    };
    // gọi phương thức ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: "POST",
        data: JSON.stringify(addNewSmartPhone()),
        // tên API
        url: "http://localhost:8080/api/smartphones",
        //xử lý khi thành công
        success: successHandler
        // -> gọi hàm successHandler -> nhưng không có cặp dấu đóng mở ngoặc??
    });
    // chặn sự kiện mặc định của thẻ -> thẻ gì?
    event.preventDefault();
}


// hàm này sẽ hiển thị thông tin lên trang web khi đăng ký thành công
// mà không cần phải tải lại trang
function successHandler() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/api/smartphones",
        // xử lý khi thành công
        success: function (data) {
            //hiển thị danh sách
            let content = '<table id=display-list border="1"><tr>\n' +
                ' <th>Producer</th>\n' +
                ' <th>Model</th>\n' +
                ' <th>Price</th>\n' +
                ' <th>Delete</th>\n' +
                ' </tr>';
            for (let i = 0; i < data.length; i++) {
                content += getSmartphone(data[i]);
            }
            content += "</table>"
            document.getElementById('smartphoneList').innerHTML = content;
            document.getElementById('smartphoneList').style.display = "block";
            document.getElementById('add-smartphone').style.display = "none";
            document.getElementById('display-create').style.display = "block";
            document.getElementById('title').style.display = "block";
        }
    });
}


function displayFormCreate() {
    document.getElementById('smartphoneList').style.display = "none";
    document.getElementById('add-smartphone').style.display = "block";
    document.getElementById('display-create').style.display = "none";
    document.getElementById('title').style.display = "none";
}

function getSmartphone(smartphone) {
    return `<tr><td >${smartphone.producer}</td><td >${smartphone.model}</td><td >${smartphone.price}</td>` +
        `<td class="btn"><button class="deleteSmartphone" onclick="deleteSmartphone(${smartphone.id})">Delete</button></td></tr>`;
}

function deleteSmartphone(id) {
    $.ajax({
        type: "DELETE",
        //tên API
        url: `http://localhost:8080/api/smartphones/${id}`,
        //xử lý khi thành công
        success: successHandler
    });
}