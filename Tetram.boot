#!/epics/support2/quadEM/bin/linux-x86_64/quadEMTestApp
errlogInit(5000)
epicsEnvSet("QUADEM","/epics/support2/quadEM")
epicsEnvSet("QUAD_DET",        "NSLS_EM.cmd")
epicsEnvSet("IOC","iocTest")
< /epics/support2/quadEM/iocBoot/iocTest/envPaths
epicsEnvSet("ARCH","linux-x86_64")
epicsEnvSet("IOC","iocTest")
epicsEnvSet("TOP","/epics/support2/quadEM")
epicsEnvSet("SUPPORT","/epics/support2")
epicsEnvSet("QUADEM","/epics/support2/quadEM")
epicsEnvSet("ASYN","/epics/support2/asyn")
epicsEnvSet("AREA_DETECTOR","/epics/support2/areaDetector")
epicsEnvSet("ADCORE","/epics/support2/areaDetector/ADCore")
epicsEnvSet("ADBINARIES","/epics/support2/areaDetector/ADBinaries")
epicsEnvSet("IPAC","/epics/support2/ipac")
epicsEnvSet("BUSY","/epics/support2/busy")
epicsEnvSet("IPUNIDIG","/epics/support2/ipUnidig")
epicsEnvSet("SNCSEQ","/epics/support2/seq")
epicsEnvSet("AUTOSAVE","/epics/support2/autosave")
epicsEnvSet("MCA","/epics/support2/mca")
epicsEnvSet("SSCAN","/epics/support2/sscan")
epicsEnvSet("CALC","/epics/support2/calc")
epicsEnvSet("DEVIOCSTATS","/epics/support2/devIocStats")
epicsEnvSet("EPICS_BASE","/epics/support2/base")
< unique.cmd
#epicsEnvSet("PREFIX",    "quadEMTest:")
#epicsEnvSet("RECORD",    "TetrAMM")
#epicsEnvSet("PORT",      "TetrAMM")
#epicsEnvSet("TEMPLATE",  "TetrAMM")
#epicsEnvSet("QSIZE",     "20")
#epicsEnvSet("RING_SIZE", "10000")
#epicsEnvSet("TSPOINTS",  "1000")
#epicsEnvSet("IP",        "164.54.160.241:10001")
#epicsEnvSet("PREFIX",    "XF:10ID-BI:")
epicsEnvSet("PREFIX",    "quadEMTest:")
epicsEnvSet("RECORD",    "TetrAMM")
epicsEnvSet("PORT",      "TetrAMM")
epicsEnvSet("TEMPLATE",  "TetrAMM")
#epicsEnvSet("MODEL",     "TetrAMM")
epicsEnvSet("QSIZE",     "20")
epicsEnvSet("RING_SIZE", "10000")
epicsEnvSet("TSPOINTS",  "1000")
epicsEnvSet("IP",        "10.10.2.178:10001")
epicsEnvSet("QUAD_DET",        "TetrAMM.cmd")
epicsEnvSet("EPICS_CA_AUTO_ADDR_LIST", "NO")
epicsEnvSet("EPICS_CA_ADDR_LIST", "10.10.0.255")
# Tell EPICS all about the record types, device-support modules, drivers,
# etc. in this build
dbLoadDatabase("/epics/support2/quadEM/dbd/quadEMTestApp.dbd")
quadEMTestApp_registerRecordDeviceDriver(pdbbase)
# The search path for database files
epicsEnvSet("EPICS_DB_INCLUDE_PATH", "/epics/support2/areaDetector/ADCore/db:/epics/support2/quadEM/db")
#< AH401B.cmd
#< AH501.cmd
#< TetrAMM.cmd
#< NSLS_EM.cmd
< /epics/support2/quadEM/iocBoot/iocTest/TetrAMM.cmd
#epicsEnvSet("PREFIX",    "quadEMTest:")
#epicsEnvSet("RECORD",    "TetrAMM")
#epicsEnvSet("PORT",      "TetrAMM")
#epicsEnvSet("TEMPLATE",  "TetrAMM")
#epicsEnvSet("QSIZE",     "20")
#epicsEnvSet("RING_SIZE", "10000")
#epicsEnvSet("TSPOINTS",  "1000")
#epicsEnvSet("IP",        "164.54.160.241:10001")
#drvAsynIPPortConfigure("portName","hostInfo",priority,noAutoConnect,
#                        noProcessEos)
drvAsynIPPortConfigure("IP_TetrAMM", "10.10.2.178:10001", 0, 0, 0)
asynOctetSetInputEos("IP_TetrAMM",  0, "\r\n")
asynOctetSetOutputEos("IP_TetrAMM", 0, "\r")
# Set both TRACE_IO_ESCAPE (for ASCII command/response) and TRACE_IO_HEX (for binary data)
asynSetTraceIOMask("IP_TetrAMM", 0, 6)
#asynSetTraceFile("IP_$(PORT)",   0, "AHxxx.out")
#asynSetTraceMask("IP_$(PORT)",   0,  9)
asynSetTraceIOTruncateSize("IP_TetrAMM", 0, 4000)
# Load asynRecord record
dbLoadRecords("/epics/support2/asyn/db/asynRecord.db", "P=quadEMTest:, R=asyn1,PORT=IP_TetrAMM,ADDR=0,OMAX=256,IMAX=256")
drvTetrAMMConfigure("TetrAMM", "IP_TetrAMM", 10000)
dbLoadRecords("/epics/support2/quadEM/db/TetrAMM.template", "P=quadEMTest:, R=TetrAMM:, PORT=TetrAMM")
< /epics/support2/quadEM/iocBoot/iocTest/commonPlugins.cmd
# Create 11 statistics plugins
NDStatsConfigure("STATS1", 20, 0, "TetrAMM", 0, 0, 0)
dbLoadRecords("/epics/support2/areaDetector/ADCore/db/NDStats.template",     "P=quadEMTest:,R=TetrAMM:Current1:, PORT=STATS1,ADDR=0,TIMEOUT=1,NDARRAY_PORT=TetrAMM,NDARRAY_ADDR=0,HIST_SIZE=256,XSIZE=10000,YSIZE=0,NCHANS=1000")
NDStatsConfigure("STATS2", 20, 0, "TetrAMM", 1, 0, 0)
dbLoadRecords("/epics/support2/areaDetector/ADCore/db/NDStats.template",     "P=quadEMTest:,R=TetrAMM:Current2:, PORT=STATS2,ADDR=0,TIMEOUT=1,NDARRAY_PORT=TetrAMM,NDARRAY_ADDR=1,HIST_SIZE=256,XSIZE=10000,YSIZE=0,NCHANS=1000")
NDStatsConfigure("STATS3", 20, 0, "TetrAMM", 2, 0, 0)
dbLoadRecords("/epics/support2/areaDetector/ADCore/db/NDStats.template",     "P=quadEMTest:,R=TetrAMM:Current3:, PORT=STATS3,ADDR=0,TIMEOUT=1,NDARRAY_PORT=TetrAMM,NDARRAY_ADDR=2,HIST_SIZE=256,XSIZE=10000,YSIZE=0,NCHANS=1000")
NDStatsConfigure("STATS4", 20, 0, "TetrAMM", 3, 0, 0)
dbLoadRecords("/epics/support2/areaDetector/ADCore/db/NDStats.template",     "P=quadEMTest:,R=TetrAMM:Current4:, PORT=STATS4,ADDR=0,TIMEOUT=1,NDARRAY_PORT=TetrAMM,NDARRAY_ADDR=3,HIST_SIZE=256,XSIZE=10000,YSIZE=0,NCHANS=1000")
NDStatsConfigure("STATS5", 20, 0, "TetrAMM", 4, 0, 0)
dbLoadRecords("/epics/support2/areaDetector/ADCore/db/NDStats.template",     "P=quadEMTest:,R=TetrAMM:SumX:,     PORT=STATS5,ADDR=0,TIMEOUT=1,NDARRAY_PORT=TetrAMM,NDARRAY_ADDR=4,HIST_SIZE=256,XSIZE=10000,YSIZE=0,NCHANS=1000")
NDStatsConfigure("STATS6", 20, 0, "TetrAMM", 5, 0, 0)
dbLoadRecords("/epics/support2/areaDetector/ADCore/db/NDStats.template",     "P=quadEMTest:,R=TetrAMM:SumY:,     PORT=STATS6,ADDR=0,TIMEOUT=1,NDARRAY_PORT=TetrAMM,NDARRAY_ADDR=5,HIST_SIZE=256,XSIZE=10000,YSIZE=0,NCHANS=1000")
NDStatsConfigure("STATS7", 20, 0, "TetrAMM", 6, 0, 0)
dbLoadRecords("/epics/support2/areaDetector/ADCore/db/NDStats.template",     "P=quadEMTest:,R=TetrAMM:SumAll:,   PORT=STATS7,ADDR=0,TIMEOUT=1,NDARRAY_PORT=TetrAMM,NDARRAY_ADDR=6,HIST_SIZE=256,XSIZE=10000,YSIZE=0,NCHANS=1000")
NDStatsConfigure("STATS8", 20, 0, "TetrAMM", 7, 0, 0)
dbLoadRecords("/epics/support2/areaDetector/ADCore/db/NDStats.template",     "P=quadEMTest:,R=TetrAMM:DiffX:,    PORT=STATS8,ADDR=0,TIMEOUT=1,NDARRAY_PORT=TetrAMM,NDARRAY_ADDR=7,HIST_SIZE=256,XSIZE=10000,YSIZE=0,NCHANS=1000")
NDStatsConfigure("STATS9", 20, 0, "TetrAMM", 8, 0, 0)
dbLoadRecords("/epics/support2/areaDetector/ADCore/db/NDStats.template",     "P=quadEMTest:,R=TetrAMM:DiffY:,    PORT=STATS9,ADDR=0,TIMEOUT=1,NDARRAY_PORT=TetrAMM,NDARRAY_ADDR=8,HIST_SIZE=256,XSIZE=10000,YSIZE=0,NCHANS=1000")
NDStatsConfigure("STATS10",20, 0, "TetrAMM", 9, 0, 0)
dbLoadRecords("/epics/support2/areaDetector/ADCore/db/NDStats.template",     "P=quadEMTest:,R=TetrAMM:PosX:,     PORT=STATS10,ADDR=0,TIMEOUT=1,NDARRAY_PORT=TetrAMM,NDARRAY_ADDR=9,HIST_SIZE=256,XSIZE=10000,YSIZE=0,NCHANS=1000")
NDStatsConfigure("STATS11",20, 0, "TetrAMM", 10, 0, 0)
dbLoadRecords("/epics/support2/areaDetector/ADCore/db/NDStats.template",     "P=quadEMTest:,R=TetrAMM:PosY:,     PORT=STATS11,ADDR=0,TIMEOUT=1,NDARRAY_PORT=TetrAMM,NDARRAY_ADDR=10,HIST_SIZE=256,XSIZE=10000,YSIZE=0,NCHANS=1000")
# Create a netCDF file saving plugin.
NDFileNetCDFConfigure("FileNetCDF1", 20, 0, "TetrAMM", 11)
dbLoadRecords("/epics/support2/areaDetector/ADCore/db/NDFileNetCDF.template","P=quadEMTest:,R=TetrAMM:netCDF1:,PORT=FileNetCDF1,ADDR=0,TIMEOUT=1,NDARRAY_PORT=TetrAMM,NDARRAY_ADDR=11")
# This creates a waveform large enough for 11x10000 arrays.
NDStdArraysConfigure("Image1", 20, 0, "TetrAMM", 11)
dbLoadRecords("/epics/support2/areaDetector/ADCore/db/NDStdArrays.template", "P=quadEMTest:,R=TetrAMM:image1:,PORT=Image1,ADDR=0,TIMEOUT=1,NDARRAY_PORT=TetrAMM,NDARRAY_ADDR=11,TYPE=Float64,FTVL=DOUBLE,NELEMENTS=110000")
asynSetTraceIOMask("TetrAMM",0,2)
#asynSetTraceMask("$(PORT)",  0,9)
# initFastSweep(portName, inputName, maxSignals, maxPoints)
#  portName = asyn port name for this new port (string)
#  inputName = name of asynPort providing data
#  maxSignals  = maximum number of signals (spectra)
#  maxPoints  = maximum number of channels per spectrum
#  dataString  = drvInfo string for current and position data
#  intervalString  = drvInfo string for time interval per point
initFastSweep("TetrAMMTS", "TetrAMM", 11, 2048, "QE_INT_ARRAY_DATA", "QE_SAMPLE_TIME")
dbLoadRecords("/epics/support2/quadEM/db/quadEM_TimeSeries.template", "P=quadEMTest:,R=TetrAMM_TS:,NUM_TS=2048,NUM_FREQ=1024,PORT=TetrAMMTS")
< /epics/support2/quadEM/iocBoot/iocTest/saveRestore.cmd
set_requestfile_path("./")
set_requestfile_path("/epics/support2/quadEM/quadEMApp/Db")
set_requestfile_path("/epics/support2/areaDetector/ADCore/ADApp/Db")
set_requestfile_path("/epics/support2/calc/calcApp/Db")
set_requestfile_path("/epics/support2/sscan/sscanApp/Db")
set_savefile_path("./as/save")
set_pass0_restoreFile("auto_settings.sav")
set_pass1_restoreFile("auto_settings.sav")
save_restoreSet_status_prefix("quadEMTest:")
dbLoadRecords("/epics/support2/autosave/asApp/Db/save_restoreStatus.db", "P=quadEMTest:")
iocInit()
############################################################################
## EPICS R3.14.12.5 $Date: Tue 2015-03-24 09:57:35 -0500$
## EPICS Base built Dec  2 2015
############################################################################
# save settings every thirty seconds
create_monitor_set("/epics/support2/quadEM/iocBoot/iocTest/auto_settings.req",30,"P=quadEMTest:, R=TetrAMM:, R_TS=TetrAMM_TS:")
save_restore:readReqFile: unable to open file /epics/support2/quadEM/iocBoot/iocTest/auto_settings.req. Exiting.
#create_monitor_set("auto_settings.req",30,"P=$(PREFIX), R=$(RECORD):, R_TS=$(RECORD)_TS:")
seq("quadEM_SNL", "P=quadEMTest:, R=TetrAMM_TS:, NUM_CHANNELS=2048")
quadEM_TimeSeries: All channels connected.
epics> 
epics> 
epics> 
epics> 
epics> 
epics> 
epics> ^C