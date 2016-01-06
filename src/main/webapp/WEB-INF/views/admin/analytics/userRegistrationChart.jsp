<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<p>
    <canvas id="userRegistrationChart" width="800" height="400"></canvas>
    <script>
        //        var data = {
        //            labels: ["January", "February", "March", "April", "May", "June", "July"],
        //            datasets: [
        //                {
        //                    label: "My First dataset",
        //                    fillColor: "rgba(220,220,220,0.2)",
        //                    strokeColor: "rgba(220,220,220,1)",
        //                    pointColor: "rgba(220,220,220,1)",
        //                    pointStrokeColor: "#fff",
        //                    pointHighlightFill: "#fff",
        //                    pointHighlightStroke: "rgba(220,220,220,1)",
        //                    data: [65, 59, 80, 81, 56, 55, 40]
        //                },
        //                {
        //                    label: "My Second dataset",
        //                    fillColor: "rgba(151,187,205,0.2)",
        //                    strokeColor: "rgba(151,187,205,1)",
        //                    pointColor: "rgba(151,187,205,1)",
        //                    pointStrokeColor: "#fff",
        //                    pointHighlightFill: "#fff",
        //                    pointHighlightStroke: "rgba(151,187,205,1)",
        //                    data: [28, 48, 40, 19, 86, 27, 90]
        //                }
        //            ]
        //        };

        var data;

        $.ajax({
            url: "/chart/userRegistrationData/",
            type: "GET",
            dataType: 'json',
            success: function (data) {


                var chartData = {
                    labels: data.labels,
                    datasets: [
                        {
                            label: "My First dataset",
                            fillColor: "rgba(151,187,205,0.2)",
                            strokeColor: "rgba(151,187,205,1)",
                            pointColor: "rgba(151,187,205,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(151,187,205,1)",
                            data: data.data
                        }
                    ]
                };


                // данные в строке, сама  строка – json –строка, ее нужно распарсить
                //   data = JSON.parse (result);
//                alert(data.labels);  // Goper
                var ctx = document.getElementById("userRegistrationChart").getContext("2d");
                var myLineChart = new Chart(ctx).Line(chartData);
            }
        });
    </script>
</p>
<p>
    <a href="/admin/analytics/">Go back</a>
</p>