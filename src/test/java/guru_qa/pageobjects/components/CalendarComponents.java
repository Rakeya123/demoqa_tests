package guru_qa.pageobjects.components;

import static com.codeborne.selenide.Selenide.$;
import static guru_qa.utils.RandomUtils.choiceMonth;
import static guru_qa.utils.RandomUtils.getRandomInt;

public class CalendarComponents {

    public void  setDate (String day, String month, String year){

     //   date selection
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month)").click();



}
}

