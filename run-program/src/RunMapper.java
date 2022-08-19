import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class RunMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
 public static final int MISSING = 9999;

 public void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text,LongWritable>.Context context) throws IOException, InterruptedException {
//	 int temperature;
//	 String line = value.toString();
//	 String year = line.substring(15, 19);
//	 if (line.charAt(87) == '+') {
//		 temperature = Integer.parseInt(line.substring(88, 92));
//	 } else {
//		 temperature = Integer.parseInt(line.substring(87, 92));
//	 }
//	 String quality = line.substring(92, 93);
//	 if (temperature != 9999 && quality.matches("[01459]"))
//		 context.write(new Text(year), new IntWritable(temperature));
//	 }
	 String line=value.toString();
	 String[] lineArr=line.split(" ");
	 int keyValue=(int) key.get();
	 for(String s:lineArr) {
		 keyValue+=s.length();
		 context.write(new Text(s),new LongWritable(keyValue));
	 }
 }
}