
$('document').ready(function () {

   $('#editButton').on('click', function (event) {


       event.preventDefault();

       var href = $(this).attr('href');

       $.get(href, function (singer, status) {

           $('#firstNameEdit').val(singer.firstName);
           $('#lastNameEdit').val(singer.lastName);
           $('#nickNameEdit').val(singer.nickName);
           $('#genreEdit').val(singer.genre);

       });
       $('#editModal').modal();
   });
});