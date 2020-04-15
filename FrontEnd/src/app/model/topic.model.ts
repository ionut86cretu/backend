import { CommentModel } from './comment.model';

export class TopicModel {
	title: string;
	mediaUrl: string;
	author: string;
  transformAction: string;
	comments: CommentModel[];
}
