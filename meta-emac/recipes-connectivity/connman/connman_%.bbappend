 
PACKAGECONFIG += " \
    ${@bb.utils.contains('EMAC_INITMANAGER', 'systemd', ' systemd ', '', d )} \
    wifi \
    bluez \
    bluetooth \
"
