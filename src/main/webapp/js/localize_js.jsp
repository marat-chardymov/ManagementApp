<%@ page contentType="text/javascript" pageEncoding="UTF-8"%>
        <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

        var messages = {
            required: '<bean:message key="messages.required"/>',
            maxlength: '<bean:message key="messages.maxlength"/>',
            dateISO: '<bean:message key="messages.dateISO"/>'
        };
        var pickerLabels = {
            daysMin: {
                Sun: '<bean:message key="datepicker.daysMin.Sun"/>',
                Mon: '<bean:message key="datepicker.daysMin.Mon"/>',
                Tue: '<bean:message key="datepicker.daysMin.Tue"/>',
                Wed: '<bean:message key="datepicker.daysMin.Wed"/>',
                Thu: '<bean:message key="datepicker.daysMin.Thu"/>',
                Fri: '<bean:message key="datepicker.daysMin.Fri"/>',
                Sat: '<bean:message key="datepicker.daysMin.Sat"/>',
                Sun: '<bean:message key="datepicker.daysMin.Sun"/>'
            },
            months: {
                January: '<bean:message key="datepicker.months.January"/>',
                February: '<bean:message key="datepicker.months.February"/>',
                March: '<bean:message key="datepicker.months.March"/>',
                April: '<bean:message key="datepicker.months.April"/>',
                May: '<bean:message key="datepicker.months.May"/>',
                June: '<bean:message key="datepicker.months.June"/>',
                July: '<bean:message key="datepicker.months.July"/>',
                August: '<bean:message key="datepicker.months.August"/>',
                September: '<bean:message key="datepicker.months.September"/>',
                October: '<bean:message key="datepicker.months.October"/>',
                November: '<bean:message key="datepicker.months.November"/>',
                December: '<bean:message key="datepicker.months.December"/>'
            }
        };

        var newsList = {
            atLeastOne: '<bean:message key="newsList.atLeastOne"/>',
            deleteConfirm: '<bean:message key="newsList.deleteConfirm"/>'
        }




