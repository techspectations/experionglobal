angular.module('newsapp').controller('ArticleCtrl',function($scope, $stateParams, confirmator, $location, $timeout, article){
    var at = this;

    var startTime = new Date().getTime();
    var articleID = $stateParams.articleID;

    if(articleID){
        article.getArticle(articleID).then(function(res){

            console.log("article : " + res);
            if(res) {
                at.article = res;
            } else {
                console.log("Yikes, no data found!");
            }
        });
    } else {
        // Handle
    }

    $scope.currentLocation = $location.url();
    $scope.$on("$locationChangeSuccess",function handleLocationChangeSuccessEvent( event ) {
            $scope.currentLocation = $location.url();
        }
    );
   
    var startWatchingTimer = $timeout( startWatchingForLocationChanges, 0, false );
    
    var stopWatchingLocation = null;
   
    function handleLocationChangeStartEvent( event ) {
        // Prevent the location from actually changing.
        event.preventDefault();
        // Keep track of which location the user was about to move to.
        var targetPath = $location.path();
        var targetSearch = $location.search();
        var targetHash = $location.hash();
        // Trigger a confirmation modal to see if the user really wanted to
        // leave the current page; this returns a promise.

        stopWatchingLocation();
        $scope.$applyAsync( startWatchingForLocationChanges );
        var stopTime = new Date().getTime();
        console.log("Time :" + startTime +" - "+stopTime);
        //= Math.floor(Math.random() * 5) + 1 ;
        find(startTime - stopTime, function(data){

            console.log("ratting:"+data);
        var data = {
            user_id : localStorage.getItem('userId'),
            news_id : articleID,
            user_rate : data
        }

        article.postUserLike(data).then(function(res) {
            console.log("User Like : " + res);
            if(res) {
                console.log("User Like : " + res);
            } else {
                console.log("User like failed");
            }
        });
        
        }); 

        
    }


    function startWatchingForLocationChanges () {
        stopWatchingLocation = $scope.$on( "$locationChangeStart", handleLocationChangeStartEvent );
    }

  
     

function find(theNumber, cb) {
theNumber=Math.abs(theNumber)
 var sum=0;
 var data =0;
    parseInt(theNumber);
    while(theNumber>0)
     {
       sum+=theNumber%10;
       theNumber=Math.floor(theNumber/10);
      }
      if(sum>10){
        find(sum)
      }else{
      console.log("Sum of digits  "+sum);
     data =  adjustment(sum);
     console.log("Sum of digits two "+data);
      }
      cb(data);
   }
 

function adjustment(sum) {
if(sum>5&&sum<=6){
console.log("data"+sum)
 sum-=4;
 }else if(sum>6&&sum<=7){
 sum-=5;
 }else if(sum>7&&sum<=8){
 sum-=6;
 }else if(sum>8&&sum<=9){
 sum-=7;
 }else{
  console.log("sum:"+sum);
 }
 console.log("final data:"+sum);
return sum;
}



});