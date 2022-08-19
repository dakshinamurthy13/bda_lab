import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class RunReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
	public void reduce(Text key, Iterable<LongWritable> values, Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {
//	int max_temp = 0;
//	int count = 0;
//	for (IntWritable value : values) {
//		 max_temp += value.get();
//		 count++;
//	}
//	context.write(key, new IntWritable(max_temp / count));
	for(LongWritable value:values) {
		context.write(key, value);
	}
	}
}