
function getForecast() {

    coord = document.getElementById('location').value.split(",");

    console.log(coord);

    console.log(fetch('http://localhost:8080/api/forecast?latitude='+coord[0]+'&longitude='+coord[1])
        .then(data=>{return data.json()})
        .then(res=>{
            console.log(res);
            var daily = res.daily.data;
            var forecast = document.getElementById("forecast");
            forecast.innerHTML = "";
            var first = true;
            for (var d in daily){
                console.log(d);
                var forecastRow = document.createElement("div");
                forecastRow.classList.add("row");
                forecastRow.classList.add("m-2");
                
                if(first){
                    var summaryInfo = document.createTextNode("Today Summary: " + daily[d]['summary']);
                    first = false;
                }else{
                    var summaryInfo = document.createTextNode("Summary: " + daily[d]['summary']);
                }

                var summary = document.createElement("div");
                summary.classList.add("col-md-4");
                summary.appendChild(summaryInfo);

                var maxTempInfo = document.createTextNode("Max Temperature: " + temperatureConverter(daily[d]['temperatureMax']) + 'ºC');
                var maxTemp = document.createElement("div");
                maxTemp.classList.add("col-md-4");
                maxTemp.appendChild(maxTempInfo);
                
                var minTempInfo = document.createTextNode("Min Temperature: " + temperatureConverter(daily[d]['temperatureMin']) + 'ºC');
                var minTemp = document.createElement("div");
                minTemp.classList.add("col-md-3");
                minTemp.appendChild(minTempInfo);

                forecastRow.appendChild(summary);
                forecastRow.appendChild(maxTemp);
                forecastRow.appendChild(minTemp);

                forecast.appendChild(forecastRow);

            }
        })
    );
}

function temperatureConverter(valNum) {
    valNum = parseFloat(valNum);
    return parseFloat(Math.round((valNum-32) / 1.8)).toFixed(0);
  } 