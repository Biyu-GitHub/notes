import os, argparse, datetime
from moviepy.editor import VideoFileClip

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='Compute Total Time of a Series of Videos')

    parser.add_argument("--path", metavar="PATH", default=".",
                        help="the root path of the videos(default: .)")

    parser.add_argument("--type", metavar="TYPE", default=".avi",
                        help="the type of the videos(default: .avi)")

    args = parser.parse_args()

    filelist = []

    for a, b, c in os.walk(args.path):
        for name in c:
            fname = os.path.join(a, name)
            if fname.endswith(args.type):
                filelist.append(fname)

    ftime = 0.0

    print(args.path + "\n")

    for i, fname in enumerate(filelist):
        i=i+1
        num = 50
        num_1 = int(i / len(filelist) * num)
        num_2 = num - num_1
        print("\rCalculate the total video time: [" + num_1 * "#" + num_2*" " + "]" + " %.2f%%"%(i / len(filelist) * 100.), end="")
        clip = VideoFileClip(fname)
        ftime += clip.duration
        clip.close()

    print("\n\nTotal time: %s,  %d minutes" % (str(datetime.timedelta(seconds=ftime))[:-7], (ftime + 60) / 60))
