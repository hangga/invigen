package io.hangga;

public class Invigen {

    public static String userDir = System.getProperty("user.dir");
    public static String template = userDir + "/template.docx";

    public static String tmp = userDir + "/output.docx";

    void generate(String names, String template, String outputPath, InvigenListener listener){

        String[] arrNames = names.split(",");
        new Generator().doing(template, outputPath, arrNames.length, new OnCopyFinish() {
            @Override
            public void OnSuccess(String output) {
                new DocProcessor().replaceName(arrNames, output, outputPath);
                listener.onSuccess(outputPath);
            }

            @Override
            public void OnError(String errMsg) {

            }
        });
    }
    void generate(String[] names, String template, String outputPath, InvigenListener listener){
        new Generator().doing(template, outputPath, names.length, new OnCopyFinish() {
            @Override
            public void OnSuccess(String output) {
                new DocProcessor().replaceName(names, output, outputPath);
                listener.onSuccess(outputPath);
            }

            @Override
            public void OnError(String errMsg) {

            }
        });
    }
}
