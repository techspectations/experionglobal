angular.module('newsapp').run(['$templateCache', function($templateCache) {
  'use strict';

  $templateCache.put('partial/home/home.html',
    "<ul class=topnav id=myTopnav><div class=container><li style=\"padding-left: 20px\"><a href=#>Home</a></li><li><a href=#>Obit</a></li><li><a href=#>Tech</a></li><li><a href=#>Movie</a></li><li><a href=#>Sports</a></li><li><a href=#>Life</a></li><li><a href=#>Health</a></li><li><a href=#>Auto</a></li><li><a href=#>Music</a></li><li><a href=#>She</a></li><li><a href=#>Travel</a></li><li><a href=#>Children</a></li><li class=icon><a href=javascript:void(0); onclick=myFunction()>&#9776;</a></li></div></ul><div class=container><div class=\"col-md-9 col-sm-12 personal_news\"><div class=\"col-md-12 per_news red\"><img src=images/news.jpg width=100% height=auto class=image_top_pad><h3>What is Lorem Ipsum?</h3><p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'.</p></div><div class=\"col-md-6 per_news red\"><img src=images/news.jpg width=100% height=auto class=image_top_pad><h3>What is Lorem Ipsum?</h3><p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'.</p></div><div class=\"col-md-5 per_news red\"><img src=images/news.jpg width=100% height=auto class=image_top_pad><h3>What is Lorem Ipsum?</h3><p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'.</p></div></div><div class=\"col-md-3 col-sm-12 main_news\"><div class=\"col-md-12 main_inner_news red\"><img src=images/news.jpg width=100% height=auto class=image_top_pad><h3>What is Lorem Ipsum?</h3><p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'.</p></div><div class=\"col-md-12 main_inner_news red\"><img src=images/news.jpg width=100% height=auto class=image_top_pad><h3>What is Lorem Ipsum?</h3><p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'.</p></div></div></div>"
  );

}]);
