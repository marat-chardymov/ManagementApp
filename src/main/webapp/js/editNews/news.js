$('.datepicker').datepicker({
    autoclose: true,
    format: 'yyyy-mm-dd',
    language: "ru-RU"
});

$("#newsForm").validate();
$("#title").rules("add", {
    required: true,
    maxlength: 100
});
$("#date").rules("add", {
    required: true,
    dateISO: true
});
$("#brief").rules("add", {
    required: true,
    maxlength: 500
});
$("#content").rules("add", {
    required: true,
    maxlength: 2048
});

jQuery.extend(jQuery.validator.messages, {
    required: messages.required,
    maxlength: jQuery.validator.format(messages.maxlength+" {0}"),
    dateISO: messages.dateISO
});
