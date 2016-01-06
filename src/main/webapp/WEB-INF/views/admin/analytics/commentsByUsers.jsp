<p>
    <canvas id="usersCommentsChart" width="800" height="400"></canvas>
    <script>

        var data;

        $.ajax({
            url: "/chart/usersComments/",
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
                var ctx = document.getElementById("usersCommentsChart").getContext("2d");
                var myLineChart = new Chart(ctx).Bar(chartData);
            }
        });
    </script>
</p>
<p>
    <a href="/admin/analytics/">Go back</a>
</p>