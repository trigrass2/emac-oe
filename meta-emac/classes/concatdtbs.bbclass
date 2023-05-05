
python do_concat_dtbs() {
    kernel_devtree_var = d.getVar("KERNEL_DEVICETREE")
    if kernel_devtree_var: # if not None
        dtbs = kernel_devtree_var.replace('\t', '').split(" ")
        deploy_dir = d.getVar("DEPLOY_DIR_IMAGE")
        for dtb in dtbs:
            if dtb is '': continue
            kernel_file = f'{deploy_dir}/zImage'
            dtb_file = f'{deploy_dir}/{dtb}'
            concat_file = f'{deploy_dir}/zImage_{dtb.replace(".dtb", "")}'
            if os.path.exists(concat_file):
                bb.warn("Concatinated zImage_dtb file already existed and has be overwritten.")
            with open(kernel_file, "rb") as kf, open(dtb_file, "rb") as df, open(concat_file, "wb") as cf:
                cf.write(kf.read())
                cf.write(df.read())
}
addtask concat_dtbs after do_deploy before do_build

python do_concat_dtbs_clean() {
    kernel_devtree_var = d.getVar("KERNEL_DEVICETREE")
    if kernel_devtree_var: # if not None
        dtbs = kernel_devtree_var.replace('\t', '').split(" ")
        deploy_dir = d.getVar("DEPLOY_DIR_IMAGE")
        for dtb in dtbs:
            if dtb is '': continue
            concat_file = f'{deploy_dir}/zImage_{dtb.replace(".dtb", "")}'
            if os.path.exists(concat_file):
                os.remove(concat_file)
}

addtask concat_dtbs_clean 
do_clean[depends] += "virtual/kernel:do_concat_dtbs_clean"
