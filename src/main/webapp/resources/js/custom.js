charts = {

    initChartist: function(nbOeuvres, nbAdherents, nbOeuvresLibres){

        var dataOeuvres = {
            labels: ["Aujourd'hui"],
            series: [[nbOeuvres]]
        };

        var optionsOeuvres = {
            seriesBarDistance: 10,
            axisX: {
                showGrid: false
            },
            height: "245px"
        };

        var responsiveOptionsOeuvres = [
            ['screen and (max-width: 640px)', {
                seriesBarDistance: 5,
                axisX: {
                    labelInterpolationFnc: function (value) {
                        return value[0];
                    }
                }
            }]
        ];

        Chartist.Bar('#chartOeuvres', dataOeuvres, optionsOeuvres, responsiveOptionsOeuvres);





        var dataAdherents = {
            labels: ["Aujourd'hui"],
            series: [[nbAdherents]]
        };

        var optionsAdherents = {
            seriesBarDistance: 10,
            axisX: {
                showGrid: false
            },
            height: "245px"
        };

        var responsiveOptionsAdherents = [
            ['screen and (max-width: 640px)', {
                seriesBarDistance: 5,
                axisX: {
                    labelInterpolationFnc: function (value) {
                        return value[0];
                    }
                }
            }]
        ];

        Chartist.Bar('#chartAdherents', dataAdherents, optionsAdherents, responsiveOptionsAdherents);

        var dataReservations = {
            series: [
                [25, 30, 20, 25]
            ]
        };

        var optionsReservations = {
            donut: true,
            donutWidth: 40,
            startAngle: 0,
            total: 100,
            showLabel: false,
            axisX: {
                showGrid: false
            }
        };

        Chartist.Pie('#chartPreferences', dataReservations, optionsReservations);

        var pourcentOeuvresLibres = (nbOeuvresLibres * 100) / nbOeuvres;
        var pourcentOeuvresReserves = 100 - pourcentOeuvresLibres;

        Chartist.Pie('#chartPreferences', {
            labels: ['Libres','Réservés'],
            series: [pourcentOeuvresLibres,pourcentOeuvresReserves]
        });
    },
}