/**
 * 
 */

// Initialize and add the map
function initMap() {
  // The location of Uluru
  var Germany = {lat:23.6102, lng: 85.2799};
  // The map, centered at Uluru
  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 4, center: Germany});
  // The marker, positioned at Uluru
  var marker = new google.maps.Marker({position: Germany, map: map});
}

