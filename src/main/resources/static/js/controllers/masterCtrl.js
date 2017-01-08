
angular.module('myApp.controllers',[]);


//Kontroler użyty na panelu userów (panel zarządzania danymi)
angular.module('myApp.controllers').controller('masterCtrl',
    ['$rootScope','$scope', '$http',
        function ($rootScope, $scope, $http) {
            //To jest uruchamiane przy każdym wejściu do widoku korzystającego z tego kontrolera
            console.log('Uruchamiam masterCtrl; M:' + $scope.M);

            //Lokalny obiekt modelu, tworzony przy każdym uruchomieniu kontrolera
            $scope.M = {};
            $scope.M.appItems = [];
            $scope.newItem = {id: '0', title: '', body: ''};
            $scope.fff = '';

            $scope.addItem = function (nnn) {
                $scope.M.appItems.push(nnn);
                $scope.nowa = {id: '', nazwa: ''};
                $scope.MMM.showNewBooking = false;
            };

            $scope.addUser = function () {
                var userToSave = $scope.M.newItem;
                return $http({
                    url: $rootScope.M.URL + '/users',
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    data: JSON.stringify(userToSave)
                }).success(function (data) {
                    console.log("OK");
                });
            };

            $scope.sendItem = function(itemToPost) {
                return $http({
                    url: $rootScope.M.URL + '/items',
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    data: JSON.stringify(itemToPost)
                    // ,
                    // params: toSave
                }).success(function(data){
                    alert('Send operation OK' + data);
                    $scope.loadArray();
                });
            };

            $scope.loadArray = function () {
                $http.get($rootScope.M.URL + '/items')
                    .success(function (data) {
                        $scope.M.appItems = data;
                    })
            };

            //functions executed on loading the view
            $scope.loadArray();

        }
    ]
);
