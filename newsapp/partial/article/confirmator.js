angular.module('newsapp').factory('confirmator',function( $q, $timeout, $window) {

    var confirmator = {};

    var currentModal = null;
    // ---
    // PULBIC METHODS.s
    // ---
    // I open the the confirm() modal with the given message and return a
    // promise. The promise will be resolved or rejected based on the result
    // of the confirmation.
    var open = function( message ) {
        // If there is already a pending confirmation modal, reject it.
        if ( currentModal ) {
            currentModal.reject();
        }
        currentModal = $q.defer();
        // Open confirmation modal in next tick.
        $timeout(function openConfirm() {
                $window.confirm(message) ?currentModal.resolve() :currentModal.reject();
                currentModal = null;
            },0,false);
        return( currentModal.promise );
    };

    confirmator.open = open;

    return confirmator;
});