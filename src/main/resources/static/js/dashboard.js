let category = "";
let lineCharts = "";

$(document).ready(function() {
	$(".graphItem").click(function(){  
	  $(".btn:first-child").html($(this).text()+' <span class="graphs"></span>');
	   category = ($(".graphsAnchor").text());
	   lineCharts.destroy();
	   if(category === "Storage ") {
			const dataS = [1,0,2,1,3,2,4];
			generateLineChart(dataS, "salesCategoryChart");	
		} else if(category == "Processor ") {
			const dataP = [7,5,10,12,6,8,9];
			generateLineChart(dataP, "salesCategoryChart");	
		} else if(category == "Graphics Card ") {
			const dataG = [12,15,11,4,7,8,10];
			generateLineChart(dataG, "salesCategoryChart");	
		} else if (category == "Motherboard ") {
			const dataM = [8,9,5,6,10,11,6];
			generateLineChart(dataM, "salesCategoryChart");
		} else if (category == "RAM ") {
			const dataR = [11,15,20,16,19,13,14];
			generateLineChart(dataR, "salesCategoryChart");			
		} else if (category == "Power Supply ") {
			const dataP = [6,5,5,7,10,4,9];
			generateLineChart(dataP, "salesCategoryChart");
		}
	});
});


function generateDoughnutChart(labelsN, dataN, element) {
			const data = {
			labels: labelsN,
			datasets: [{
				label: "Listing Categories",
				data: dataN,
			    backgroundColor: [
			      'rgb(205, 231,202)',
			      'rgb(194, 197, 204)',
			      'rgb(144, 180, 147)',
			      'rgb(0,128,0)',
			      'rgb(144,238,144)',
			      'rgb(119,136,153)'
			    ],
			    hoverOffset: 4
			}],
			options: {
				animation: {
					animateScale: true
				}
			}
		}
	
		const config = {
	    	type: 'doughnut',
	    	data: data,
	    };
	    
	    new Chart(document.getElementById(element).getContext("2d"),config);
		
	}
    function generateLineChart(dataN, element) {
	const data = {
		labels: ["January", "February", "March", "April", "May", "June", "July"],
		datasets: [{
			label: "Sales",
			data: dataN,
		    borderColor: [
		      'rgb(144, 180, 147)',
		    ],
		    tension: 0.1
		}],
		options: {
			animation: {
				animateScale: true
			},
			responsive: true
		}
	}

	const config = {
    	type: 'line',
    	data: data
    };
    
    lineCharts = new Chart(document.getElementById(element).getContext("2d"),config);
    
}



const dataE = [0,0,0,0,0,0,0]
generateLineChart(dataE, "salesCategoryChart");

//Doughnut Chart
const labelD = ["Processor", "Motherboard", "Graphics Card", "RAM", "Storage", "Power Supply"];
const dataD = [5,8,2,13,9,4];
generateDoughnutChart(labelD, dataD, "categoryChart")
  