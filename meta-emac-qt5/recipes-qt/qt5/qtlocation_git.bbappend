PACKAGECONFIG += " \
    geoservices_esri \
    geoservices_here \
    geoservices_itemsoverlay \
    geoservices_mapbox \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'geoservices_mapboxgl', '', d)} \
    geoservices_osm \
"
