import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class RunDriver {
 public static void main(String[] args) throws Exception {
		 if (args.length != 2) {
			 System.err.println("Please Enter the input and output parameters");
			 System.exit(-1);
		 }
		 Job job = new Job();
		 job.setJarByClass(RunDriver.class);
		 job.setJobName("Max temperature");
		 FileInputFormat.addInputPath(job, new Path(args[0]));
		 FileOutputFormat.setOutputPath(job, new Path(args[1]));
		 job.setMapperClass(RunMapper.class);
		 job.setReducerClass(RunReducer.class);
		 job.setOutputKeyClass(Text.class);
		 job.setOutputValueClass(LongWritable.class);
		 System.exit(job.waitForCompletion(true) ? 0 : 1);
	 }
}