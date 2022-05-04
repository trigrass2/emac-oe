
python do_concat_dtbs() {
    dtbs = d.getVar("KERNEL_DEVICETREE").replace('\t', '').split(" ")
    deploy_dir = d.getVar("DEPLOY_DIR_IMAGE")
    for dtb in dtbs:
        if dtb is '': continue
        kernel_file = f'{deploy_dir}/zImage'
        dtb_file = f'{deploy_dir}/{dtb}'
        concat_file = f'{deploy_dir}/zImage_{dtb.replace(".dtb", "")}'
        with open(kernel_file, "rb") as kf, open(dtb_file, "rb") as df, open(concat_file, "wb") as cf:
            cf.write(kf.read())
            cf.write(df.read())
}
addtask concat_dtbs after do_deploy before do_build

python do_concat_dtbs_clean() {
    dtbs = d.getVar("KERNEL_DEVICETREE").replace('\t', '').split(" ")
    deploy_dir = d.getVar("DEPLOY_DIR_IMAGE")
    for dtb in dtbs:
        if dtb is '': continue
        concat_file = f'{deploy_dir}/zImage_{dtb.replace(".dtb", "")}'
        os.remove(concat_file)
}

addtask concat_dtbs_clean 
do_clean[depends] += "virtual/kernel:do_concat_dtbs_clean"
