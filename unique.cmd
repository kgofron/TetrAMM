#epicsEnvSet("PREFIX",    "quadEMTest:")
#epicsEnvSet("RECORD",    "TetrAMM")
#epicsEnvSet("PORT",      "TetrAMM")
#epicsEnvSet("TEMPLATE",  "TetrAMM")
#epicsEnvSet("QSIZE",     "20")
#epicsEnvSet("RING_SIZE", "10000")
#epicsEnvSet("TSPOINTS",  "1000")
#epicsEnvSet("IP",        "164.54.160.241:10001")

epicsEnvSet("PREFIX",    "XF:10ID-BI:")
epicsEnvSet("RECORD",    "TM176:")
epicsEnvSet("PORT",      "TM176")
epicsEnvSet("TEMPLATE",  "TetrAMM")
#epicsEnvSet("MODEL",     "TetrAMM")
epicsEnvSet("QSIZE",     "20")
epicsEnvSet("RING_SIZE", "10000")
epicsEnvSet("TSPOINTS",  "1000")
# epicsEnvSet("IP",        "10.10.2.176:10001")
epicsEnvSet("IP",        "10.66.74.177:10001")
epicsEnvSet("QUAD_DET",        "TetrAMM.cmd")

epicsEnvSet("EPICS_CA_AUTO_ADDR_LIST", "NO")
epicsEnvSet("EPICS_CA_ADDR_LIST", "10.10.0.255")

epicsEnvSet("EPICS_CA_MAX_ARRAY_BYTES", "1000000")

epicsEnvSet("ENGINEER",  "kgofron x5283")
epicsEnvSet("LOCATION",  "740 IXS beamline")
