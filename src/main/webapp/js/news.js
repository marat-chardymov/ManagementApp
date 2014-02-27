$('.datepicker').datepicker({
    autoclose: true,
    format: 'yyyy-mm-dd',
    language: "ru-RU"
});
$('.datepicker').datepicker('update', new Date());

$("#newsForm").validate();
$( "#title" ).rules( "add", {
    required: true,
    maxlength: 100
});
$( "#brief" ).rules( "add", {
    required: true,
    maxlength: 500
});
$( "#content" ).rules( "add", {
    required: true,
    maxlength: 2048
});
